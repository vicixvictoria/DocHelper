import {LabValue} from "./labValue";


export class LabMeasure {
  constructor(
    public id: number,
    public labValue: LabValue,
    public measuredValue: number,
    public refValueBigger: number,
    public refValueLower: number,
    public refValueFrom: number,
    public refValueTo: number
  ) {}
}
