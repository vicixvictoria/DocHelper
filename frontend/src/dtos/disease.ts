import {TestValueThreshold} from "./testValueThreshold";

export class Disease {
  constructor(
    public diseaseId: number,
    public diseaseName: string,
    public icdCode: string,
    public description: string,
    public pregnant: boolean,
    public minAge: number,
    public maxAge: number,
    public threshold: number,
    public threshold_DiseaseValue: TestValueThreshold[]
  )
  {
  }
}
