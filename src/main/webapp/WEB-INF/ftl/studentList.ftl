<table>
	<#if studentList?exists>
		<#list studentList as student>
			<tr>
				<td>
					${student.name}
				</td>
				<td>
					${student.gender}
				</td>
			</tr>
		</#list>
	</#if>
</table>
