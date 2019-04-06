package com.tanveershafeeprottoy.rxandroiddemo;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    private ViewDataBinding viewDataBinding;
    private int variableId;

    public BaseRecyclerViewHolder(
        ViewDataBinding viewDataBinding,
        int variableId
    ) {
        super(viewDataBinding.getRoot());
        this.viewDataBinding = viewDataBinding;
        this.variableId = variableId;
    }

    public void bind(T type) {
        viewDataBinding.setVariable(variableId, type);
        viewDataBinding.executePendingBindings();
    }
}
