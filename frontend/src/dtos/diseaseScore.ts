import {Disease} from "./disease";
import {BehaviorSubject} from "rxjs";

export class DiseaseScore {

  constructor(
   public disease: Disease,
   public score: number

  )
  {
  }
}
