package converter;

import dto.ModuleDTO;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "moduleConverter")
public class ModuleConverter implements Converter, Serializable {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String[] part = value.split(":");
        return new ModuleDTO(Integer.parseInt(part[0]), "", 0, 0);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null
                && value instanceof ModuleDTO) {
            ModuleDTO module = (ModuleDTO) value;
            return module.toString();
        }

        return "";
    }

}
