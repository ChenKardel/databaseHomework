package Table;

public class FkInformation
{
    private String fkName;
    private String pkName;
    private String pkTableName;
    private String pkColumnName;
    private String fkTableName;
    private String fkColumnName;

    public FkInformation(String fkName, String pkName, String pkTableName, String pkColumnName, String fkTableName, String fkColumnName)
    {
        this.fkName = fkName;
        this.pkName = pkName;
        this.pkTableName = pkTableName;
        this.pkColumnName = pkColumnName;
        this.fkTableName = fkTableName;
        this.fkColumnName = fkColumnName;
    }

    public String getPkTableName()
    {
        return pkTableName;
    }

    public void setPkTableName(String pkTableName)
    {
        this.pkTableName = pkTableName;
    }

    public String getPkColumnName()
    {
        return pkColumnName;
    }

    public void setPkColumnName(String pkColumnName)
    {
        this.pkColumnName = pkColumnName;
    }

    public String getFkTableName()
    {
        return fkTableName;
    }

    public void setFkTableName(String fkTableName)
    {
        this.fkTableName = fkTableName;
    }

    public String getFkColumnName()
    {
        return fkColumnName;
    }

    public void setFkColumnName(String fkColumnName)
    {
        this.fkColumnName = fkColumnName;
    }

    public String getPkName()
    {
        return pkName;
    }

    public void setPkName(String pkName)
    {
        this.pkName = pkName;
    }

    public String getFkName()
    {
        return fkName;
    }

    public void setFkName(String fkName)
    {
        this.fkName = fkName;
    }
}
