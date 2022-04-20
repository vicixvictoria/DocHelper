import {Gender} from "../global/gender";

export class Patient {
  constructor(
    public id: number,
    public firstname: string,
    public lastname: string,
    public svnr: number,
    public pregnant: boolean,
    public birthday: Date,
    public gender: Gender
  )
  {
  }
}
