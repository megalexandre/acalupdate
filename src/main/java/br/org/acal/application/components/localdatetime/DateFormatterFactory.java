package br.org.acal.application.components.localdatetime;

import javax.swing.*;
import javax.swing.text.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatterFactory {

    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static DefaultFormatterFactory createFormatterFactory() {
        DateFormatter dateFormatter = new DateFormatter(new SimpleDateFormat(DATE_PATTERN)) {
            @Override
            public Object stringToValue(String text) {
                if (text == null || text.isEmpty()) {
                    return null;
                }
                return LocalDate.parse(text, LOCAL_DATE_FORMATTER);
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                if (value instanceof LocalDate) {
                    return ((LocalDate) value).format(LOCAL_DATE_FORMATTER);
                }
                return super.valueToString(value);
            }
        };

        return new DefaultFormatterFactory(dateFormatter);
    }

    public static void addDateFilter(JFormattedTextField field) {
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DateDocumentFilter());
    }

    private static class DateDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (isValidInput(fb, string)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
            if (isValidInput(fb, string)) {
                super.replace(fb, offset, length, string, attrs);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }

        private boolean isValidInput(FilterBypass fb, String input) throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText + input;
            return newText.matches("\\d{0,2}/\\d{0,2}/\\d{0,4}") || newText.isEmpty();
        }
    }
}
