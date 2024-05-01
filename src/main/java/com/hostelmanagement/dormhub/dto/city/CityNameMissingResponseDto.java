package com.hostelmanagement.dormhub.dto.city;

import com.hostelmanagement.dormhub.dto.BaseExceptionDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class CityNameMissingResponseDto extends BaseExceptionDto {

}
