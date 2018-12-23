package com.shijo.view.weather;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.shijo.view.base.BaseFragment;
import javax.inject.Inject;

public class ForecastFragment extends BaseFragment {
  @BindView(R.id.recyclerViewForecast) RecyclerView mForecastRecyclerView;
  @Inject public Activity mActivity;
  @Inject public ForecastAdapter mAdapter;

  public static ForecastFragment newInstance() {
    Bundle args = new Bundle();
    ForecastFragment fragment = new ForecastFragment();
    fragment.setArguments(args);
    return fragment;
  }

  public static String getFragmentTag() {
    return ForecastFragment.class.getSimpleName();
  }

  @Override public void onAttach(@NonNull Activity context) {
    super.onAttach(context);
  }

  @Override public void onAttach(@NonNull Context context) {
    super.onAttach(context);
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_forcast, container, false);
    setUp(view);
    return view;
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity);
    mForecastRecyclerView.setLayoutManager(layoutManager);
    mForecastRecyclerView.setAdapter(mAdapter);
  }

  @Override protected void setUp(View view) {
    if (getActivityComponent() != null) {
      getActivityComponent().inject(this);
      setUnBinder(ButterKnife.bind(this, view));
    }
  }
}
