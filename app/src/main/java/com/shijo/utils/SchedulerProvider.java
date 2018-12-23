package com.shijo.utils;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

  Scheduler ui();

  Scheduler computation();

  Scheduler io();
}
