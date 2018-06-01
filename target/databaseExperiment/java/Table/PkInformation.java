package Table;

public class PkInformation
{
    private String columnName;
    private String tableName;
    private String pkName;

    public PkInformation(String columnName, String tableName, String pkName)
    {
        this.columnName = columnName;
        this.tableName = tableName;
        this.pkName = pkName;
    }

    public String getPkName()
    {
        return pkName;
    }

    public void setPkName(String pkName)
    {
        this.pkName = pkName;
    }

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }
}
