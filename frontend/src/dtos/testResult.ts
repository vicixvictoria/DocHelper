import {Patient} from "./patient";
import {LabMeasure} from "./labMeasure";

export class TestResult {
  constructor(
    public id: number,
    public labMeasures: LabMeasure[],
    public patientId: number,
    public date: Date,
  )
  {
  }
}
