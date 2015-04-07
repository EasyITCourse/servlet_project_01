package entity;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public abstract class AbstractModelBean implements Serializable {


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        //Logic
        result = prime * result + result >>> 2;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        // ******** Logic ***********
        //*****
        //*****
        return true;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
