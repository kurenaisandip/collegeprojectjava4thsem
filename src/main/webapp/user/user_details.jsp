<form method="post" action="">
    <input type="hidden" name="id" value="${student.id}">
    <label>Email: ${student.email}</label>
    <br>
    <label>Date of Birth: ${student.DOB}</label>
    <br>
    <label>ID Type: ${student.id_Type}</label>
    <br>
    <label>ID Number: ${student.id_number}</label>
    <br>
    <label>Authority: ${student.authority}</label>
    <br>
    <label>State: ${student.state}</label>
    <br>
    <label>Date: ${student.date}</label>
    <br>
    <label>Plate No: ${student.plate_No}</label>
    <br>
    <label>Manufacturer: ${student.manufacturer}</label>
    <br>
    <label>Motor Damage: ${student.motor_Dmg}</label>
    <br>
    <label>Plan: ${student.plan}</label>
    <br>
    <label>Validity Period: ${student.validityPeriod}</label>
    <br>
    <label>Mobile Number: ${student.mobile_Number}</label>
    <br>
    <label>E-Value: ${student.evalue}</label>
    <br>

    <img src="data:image/png;base64,${base64Image}">
    <tr>
        <td><a href="User?page=userEdit&id=${student.id}">Edit</a></td>
<%--        <td><a href="User?page=deleteUser&id=${student.id}">Delete</a></td>--%>
        <td><a href="User?page=deleteUser&id=${student.id}">Delete</a></td>

    </tr>
</form>
