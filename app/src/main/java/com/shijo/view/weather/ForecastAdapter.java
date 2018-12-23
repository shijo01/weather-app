package com.shijo.view.weather;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shijo.contracts.ForecastAdapterPresenterContract;
import com.shijo.contracts.ForecastAdapterViewContract;
import com.shijo.presenter.ForecastAdapterPresenter;
import javax.inject.Inject;

public class ForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  @Inject ForecastAdapterPresenterContract<ForecastAdapterViewContract> mPresenter;


  public ForecastAdapter(ForecastAdapterPresenter<ForecastAdapterViewContract> presenter) {
    mPresenter = presenter;
  }

  @NonNull @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item_forecast, parent, false);

    return new ForecastViewHolder(view);
  }

  @SuppressLint("SetTextI18n") @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    mPresenter.onBindForecastItemAtPosition(position, (ForecastViewHolder) holder);
  }

  @Override public int getItemCount() {
    return mPresenter.getForecastItemsCount();
  }
}
