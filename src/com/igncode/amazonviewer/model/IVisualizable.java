package com.igncode.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	Date startToSee(Date dateI);//hora que empezamos a ver
	void stopToSee(Date dateI, Date dateF);//hora que finaliza
}
