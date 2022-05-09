import {Patient} from "./patient";

export class TestResult {
  constructor(
    public id: number,
    public patientId: number,
    public date: Date,
  )
  {
  }
}
