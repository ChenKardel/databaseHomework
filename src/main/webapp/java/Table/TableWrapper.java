package Table;

import java.util.ArrayList;

public class TableWrapper<Entity>
{
    private ArrayList<Entity> entities;
    private ArrayList<PkInformation> pkInformations;
    private ArrayList<FkInformation> fkInformations;

    public TableWrapper(ArrayList<Entity> entities, ArrayList<PkInformation> pkInformations, ArrayList<FkInformation> fkInformations)
    {
        this.pkInformations = pkInformations;
        this.entities = entities;
        this.fkInformations = fkInformations;
    }

    public ArrayList<Entity> getEntities()
    {
        return entities;
    }

    public ArrayList<PkInformation> getPkInformations()
    {
        return pkInformations;
    }

    public ArrayList<FkInformation> getFkInformations()
    {
        return fkInformations;
    }

    public void setEntities(ArrayList<Entity> entities)
    {
        this.entities = entities;
    }

    public void setPkInformations(ArrayList<PkInformation> pkInformations)
    {
        this.pkInformations = pkInformations;
    }

    public void setFkInformations(ArrayList<FkInformation> fkInformations)
    {
        this.fkInformations = fkInformations;
    }
}

