package com.darka.baram.vo;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class ScorePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	private String userName;

	@EqualsAndHashCode.Include
	private String baseDate;

	public ScorePK(String baseDate) {
		this.baseDate = baseDate;
	}
/*
	public void setBaseDate(String baseDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			this.baseDate = format.parse(baseDate);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			baseDate = null;
		}
	}
*/
}