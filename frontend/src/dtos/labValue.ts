import {Category} from "../global/category";


export class LabValue {
  constructor(
    public labValId: number,
    public labValName: string,
    public unit: String,
    public category: Category
  )
  {
  }
}
