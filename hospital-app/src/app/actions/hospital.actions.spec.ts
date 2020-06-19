import * as fromHospital from './hospital.actions';

describe('loadHospitals', () => {
  it('should return an action', () => {
    expect(fromHospital.loadHospitals().type).toBe('[Hospital] Load Hospitals');
  });
});
