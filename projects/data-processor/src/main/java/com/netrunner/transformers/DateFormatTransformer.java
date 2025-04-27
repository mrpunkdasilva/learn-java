package com.netrunner.transformers;

import com.netrunner.core.DataTransformer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTransformer implements DataTransformer<Date> {
    @Override
    public Date transform(Date input, String... params) {
        if (input == null || params.length == 0) {
            return input;
        }

        try {
            String pattern = params[0];
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            String formattedDate = formatter.format(input);
            return formatter.parse(formattedDate);
        } catch (Exception e) {
            throw new RuntimeException("Error formatting date", e);
        }
    }
}