package com.shijo.view.weather;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.shijo.contracts.ForecastAdapterViewContract;
import com.squareup.picasso.Picasso;

public class ForecastViewHolder extends RecyclerView.ViewHolder
    implements ForecastAdapterViewContract {
  @BindView(R.id.textViewDay) public TextView mDayTextView;
  @BindView(R.id.imageViewIcon) public ImageView mIconImageView;
  @BindView(R.id.textViewTemp) public TextView mTemperatureTextView;

  public ForecastViewHolder(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  @Override public void setDayAndCondition(String data) {
    mDayTextView.setText(data);
  }

  @Override public void setWeatherConditionImage(String url) {
    Picasso.get().load(url).into(mIconImageView);
  }

  @Override public void setMinimumAndMaximumTemperature(String temperature) {
    mTemperatureTextView.setText(temperature);
  }

  @Override public void onError(int resId) {

  }

  @Override public void onError(String message) {

  }

  @Override public boolean isNetworkConnected() {
    return false;
  }
}
