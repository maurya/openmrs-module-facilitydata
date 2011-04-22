/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.facilitydata.web.taglib;

import org.apache.log4j.Logger;
import org.openmrs.api.context.Context;
import org.openmrs.module.facilitydata.model.FacilityDataQuestion;
import org.openmrs.module.facilitydata.model.NumericFacilityDataQuestionType;
import org.openmrs.module.facilitydata.model.enums.Frequency;
import org.openmrs.module.facilitydata.service.FacilityDataService;

public class FacilityDataFunctions {
	
    protected static final Logger log = Logger.getLogger(FacilityDataFunctions.class);

    public static boolean isNumericQuestion(FacilityDataQuestion question) {
        return NumericFacilityDataQuestionType.class.isAssignableFrom(question.getQuestionType().getClass());
    }
    
    public static String getDays(String s) {
        if(s == null || s.equals("")) return "";
        String[] sp = s.split(":");
        if(sp.length >= 1)
            return sp[0];        
        return "";
    }

    public static String getReason(String s) {
        if(s == null || s.equals("")) return "";
        String[] sp = s.split(":");
        if(sp.length > 1)
            return sp[1];
        return "";
    }

    public static String getYear(String date) {
        return date.substring(0,4);
    }

    public static String getMonth(String date) {
        return date.split("/")[1];
    }

    public static boolean hasText(String str) {
        return str != null && str.length() > 0;
    }

    public static String getDataType(FacilityDataQuestion question) {
        return question != null ? question.getClass().getSimpleName() : "";
    }

    public static boolean isMonthly(int schemaId) {
        return Context.getService(FacilityDataService.class).getFacilityDataFormSchema(schemaId).getFrequency() == Frequency.MONTHLY;
    }
}