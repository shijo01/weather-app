package com.shijo.view.base;

import com.shijo.model.DataManager;
import com.shijo.utils.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

public class BasePresenter<V extends BaseViewContract> implements BasePresenterContract<V> {
  private V mView;
  private DataManager mDataManager;
  private SchedulerProvider mSchedulerProvider;
  private CompositeDisposable mCompositeDisposable;

  @Inject public BasePresenter(DataManager dataManager, SchedulerProvider schedulerProvider,
      CompositeDisposable compositeDisposable) {
    this.mDataManager = dataManager;
    this.mSchedulerProvider = schedulerProvider;
    this.mCompositeDisposable = compositeDisposable;
  }

  public DataManager getDataManager() {
    return mDataManager;
  }

  public SchedulerProvider getSchedulerProvider() {
    return mSchedulerProvider;
  }

  public CompositeDisposable getCompositeDisposable() {
    return mCompositeDisposable;
  }

  @Override public void onAttach(V mvpView) {
    this.mView = mvpView;
  }

  @Override public void onDetach() {
    mView = null;
  }

  public boolean isViewAttached() {
    return mView != null;
  }

  public V getView() {
    return mView;
  }

  public void checkViewAttached() {
    if (!isViewAttached()) {
      throw new MvpViewNotAttachedException();
    }
  }

  @SuppressWarnings("serial") public static class MvpViewNotAttachedException
      extends RuntimeException {

    public MvpViewNotAttachedException() {
      super("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter");
    }
  }
}
