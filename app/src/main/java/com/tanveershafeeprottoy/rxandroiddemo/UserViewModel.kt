package com.tanveershafeeprottoy.rxandroiddemo

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author Tanveer Shafee Prottoy
 */
class UserViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val asyncTaskRunning = ObservableBoolean(false)
    val userListMutableLiveData: MutableLiveData<List<User>> = MutableLiveData()
    val userListMapMutableLiveData: MutableLiveData<List<User>> = MutableLiveData()
    val throwableSingleLiveEvent: SingleLiveEvent<Throwable> = SingleLiveEvent()

    init {
        getAll()
        getMapped()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    private fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private fun getAll() {
        addDisposable(
            UserRepo.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    setAsyncTaskRunning()
                }
                .subscribe(
                    {
                        onSuccess(it)
                    }, {
                        onFailure(it)
                    }
                )
        )
    }

    private fun getMapped() {
        addDisposable(
            UserRepo.getAll()
                .map { userList: List<User> -> userList.asReversed() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    setAsyncTaskRunning()
                }
                .subscribe(
                    {
                        onSuccessMap(it)
                    }, {
                        onFailure(it)
                    }
                )
        )
    }

    private fun onSuccess(userList: List<User>) {
        userListMutableLiveData.value = userList
        resetAsyncTaskRunning()
    }

    private fun onSuccessMap(userList: List<User>) {
        userListMapMutableLiveData.value = userList
        resetAsyncTaskRunning()
    }

    private fun onFailure(throwable: Throwable) {
        throwableSingleLiveEvent.value = throwable
        resetAsyncTaskRunning()
    }

    private fun setAsyncTaskRunning() {
        asyncTaskRunning.set(true)
    }

    private fun resetAsyncTaskRunning() {
        asyncTaskRunning.set(false)
    }
}