import { Pipe, PipeTransform } from '@angular/core';
import { Doctor } from '../../../shared/models/doctors.model';

@Pipe({
  name: 'filter',
})
export class FilterPipe implements PipeTransform {
  transform(doctors: Doctor[], search = ''): Doctor[] {
    if (search.length === 0) return doctors;
    const doctorFilter = doctors.filter((speciality) =>
      speciality.speciality.includes(search)
    );
    return doctorFilter;
  }
}
