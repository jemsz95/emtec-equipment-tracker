import { Pipe, PipeTransform } from '@angular/core';
import * as moment from 'moment/moment'

@Pipe({name: 'timeFromNow'})
export class TimeFromNowPipe implements PipeTransform {
  transform(date: Date): string {
    return moment(date).fromNow();
  }
}
