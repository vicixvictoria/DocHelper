import {Patient} from "./patient";

export class TestResult {
  constructor(
    public id: number,
    public patient: Patient,
    public date: Date,
  )
  {
  }
}
