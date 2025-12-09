<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head><title>Employee Form</title></head>
    <body>
        <h2>${employee != null ? "Edit" : "Add"} Employee</h2>

        <form action="employees" method="post">
            <input type="hidden" name="id" value="${employee.id}" />

            Name: <input type="text" name="name" value="${employee.name}" required /><br/>

            Department:
            <select name="department">
                <option value="HR" <c:if test="${employee.department == 'HR'}">selected</c:if>>HR</option>
                <option value="IT" <c:if test="${employee.department == 'IT'}">selected</c:if>>IT</option>
                <option value="Finance" <c:if test="${employee.department == 'Finance'}">selected</c:if>>Finance</option>
                <option value="Marketing" <c:if test="${employee.department == 'Marketing'}">selected</c:if>>Marketing</option>
                </select><br/>

                Salary: <input type="number" step="0.01" name="salary" value="${employee.salary}" required /><br/>

            DOB: <input type="date" name="dob" value="${employee.dob}" required /><br/>

            Gender:
            <input type="radio" name="gender" value="Male"
                   <c:if test="${employee.gender == 'Male'}">checked</c:if> />Male
                   <input type="radio" name="gender" value="Female"
                   <c:if test="${employee.gender == 'Female'}">checked</c:if> />Female<br/>



            <c:set var="empSkills" value="${employee.skills}" />

            Skills:
            <label>
                <input type="checkbox" name="skills" value="Java"
                       <c:if test="${empSkills != null and empSkills.contains('Java')}">checked</c:if> /> Java
                </label>

                <label>
                    <input type="checkbox" name="skills" value="SQL"
                    <c:if test="${empSkills != null and empSkills.contains('SQL')}">checked</c:if> /> SQL
                </label>

                <label>
                    <input type="checkbox" name="skills" value="HTML"
                    <c:if test="${empSkills != null and empSkills.contains('HTML')}">checked</c:if> /> HTML
                </label>

                <label>
                    <input type="checkbox" name="skills" value="CSS"
                    <c:if test="${empSkills != null and empSkills.contains('CSS')}">checked</c:if> /> CSS
                </label>
                <br/>

                
                
                
                Full-Time:
                <input type="checkbox" name="fullTime" value="true"
                <c:if test="${employee.fullTime}">checked</c:if> />Yes<br/><br/>

            <input type="submit" value="Save" />
            <a href="employees">Cancel</a>
        </form>
    </body>
</html>
