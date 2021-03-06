package org.reflection_no_reflection;

import java.lang.reflect.Type;
import java.util.List;

/**
 * This is the base class for all RNR implementation of fields.
 * It has the exact same API as Java core reflection fields, and
 * can contain extra methods if required.
 * Subclass will provide their own implementations of the various field methods.
 */
public class Field extends Member {

    private String name;
    private final Class<?> type;
    private Class<?> enclosingClass;
    private int modifiers;

    public Field(String name, Class<?> type, Class<?> enclosingClass, int modifiers, List<Annotation> annotationList) {
        this.name = name;
        this.type = type;
        this.enclosingClass = enclosingClass;
        this.modifiers = modifiers;
        setRnRAnnotationList(annotationList);
    }


    public Class<?> getDeclaringClass() {
        return enclosingClass;
    }

    public Type getGenericType() {
        return null; //not implemented
    }

    public int getModifiers() {
        return modifiers;
    }

    public String getName() {
        return name;
    }

    public Class<?> getType() {
        return type;
    }

    public int hashCode() {
        return 0; //not implemented
    }

    public boolean isEnumConstant() {
        return false; //not implemented
    }

    public boolean isSynthetic() {
        return false; //not implemented
    }

    public String toGenericString() {
        return null; //not implemented
    }

    public String toString() {
        return null; //not implemented
    }

    public static String getTypeName(Class<?> returnType) {
        return returnType.toString();
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Field field = (Field) o;

        if (!name.equals(field.name)) {
            return false;
        }
        return enclosingClass.equals(field.enclosingClass);
    }

    public void setAccessible(boolean accessible) {
        //do nothing
    }

    public void set(Object instance, Object value) {
        enclosingClass.getReflector().setObjectField(instance, getName(), value);
    }

    public void setByte(Object instance, byte value) {
        enclosingClass.getReflector().setByteField(instance, getName(), value);
    }

    public void setShort(Object instance, short value) {
        enclosingClass.getReflector().setShortField(instance, getName(), value);
    }

    public void setInt(Object instance, int value) {
        enclosingClass.getReflector().setIntField(instance, getName(), value);
    }

    public void setLong(Object instance, long value) {
        enclosingClass.getReflector().setLongField(instance, getName(), value);
    }

    public void setFloat(Object instance, float value) {
        enclosingClass.getReflector().setFloatField(instance, getName(), value);
    }

    public void setDouble(Object instance, double value) {
        enclosingClass.getReflector().setDoubleField(instance, getName(), value);
    }

    public void setChar(Object instance, char value) {
        enclosingClass.getReflector().setCharField(instance, getName(), value);
    }

    public void setBoolean(Object instance, boolean value) {
        enclosingClass.getReflector().setBooleanField(instance, getName(), value);
    }

}
