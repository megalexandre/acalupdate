package br.org.acal.application.components.combobox;

public abstract class JComboBoxDefault {

    public static final String SELECT = "Selecione";
    public static final String EMPTY = "";

    public abstract String getName();

    public boolean isSelectOption(){
        return SELECT.equals(getName());
    }
}
