import { createAction, props } from '@ngrx/store';

export const loadHospitals = createAction(
  '[Hospital] Load Hospitals'
);

export const loadHospitalsSuccess = createAction(
  '[Hospital] Load Hospitals Success',
  props<{ data: any }>()
);

export const loadHospitalsFailure = createAction(
  '[Hospital] Load Hospitals Failure',
  props<{ error: any }>()
);
