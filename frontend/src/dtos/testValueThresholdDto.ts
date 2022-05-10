import {Type} from "../global/type";
import {LabValue} from "./labValue";

export class TestValueThresholdDto {
  constructor(
    public thresholdId: number,
    public type: Type,
    public refVal_overwrite: number,
    public weightValue: number,
    public diseaseName: string,
    public labValName: string,
    public labVal: LabValue,
  )
  {
  }
}
