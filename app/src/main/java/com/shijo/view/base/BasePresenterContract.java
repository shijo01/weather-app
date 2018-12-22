package com.shijo.view.base;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface BasePresenterContract<V extends BaseViewContract> {
  void onAttach(V mvpView);

  void onDetach();
}
