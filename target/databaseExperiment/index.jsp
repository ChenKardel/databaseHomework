<html>
<%--<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>--%>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Controller.Selector" %>
<%@ page import="Table.TableWrapper" %>
<%@ page import="java.util.ArrayList" pageEncoding="utf-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>--%>

<body>
<script src="resources/layui/layui.js"></script>
<script src="resources/jquery-3.3.1.js"></script>
<link rel="stylesheet" type="text/css" href="resources/DataTables/datatables.css" />
<script src="resources/DataTables/datatables.js"></script>
<h2>Hello World!</h2>
<table id="tableShower" width="100%">
    <thead>
    <tr>
        <th>ApplyNum</th>
        <th>ApplyTime</th>
        <th>Reason</th>
        <th>State</th>
        <th>StudentNum</th>
        <th>LessonNum</th>
        <th>TeacherNum</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>ApplyNum</th>
        <th>ApplyTime</th>
        <th>Reason</th>
        <th>State</th>
        <th>StudentNum</th>
        <th>LessonNum</th>
        <th>TeacherNum</th>
    </tr>
    </tfoot>
</table>
<script>
    $(document).ready(function () {
        $("#tableShower").DataTable({
            pagingType: 'full_numbers',
            processing: true,
            serverSide: true,
            ordering: true,
            ajax: "../leaveApply",

        });
    })
</script>
</body>
</html>
