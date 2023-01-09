<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 상세정보 페이지</title>
</head>

<body>

<style>
	table{
	border:2px solid;
	}
	th,td{
	border:1px solid;
	}
</style>

<c:if test="${semester==null || semester.size()==0 }">
	<div>검색결과가 존재하지 않습니다.</div>
</c:if>



<table >
		<tr>
			<th>NO</th>
			<th>이름</th>
			<th>사원번호</th>
			<th>직급</th>
			<th>부서</th>
		</tr>
	
		<tr>
			<td>${semester.get(0).NO}</td>
			<td>${semester.get(0).NAME}</td>
			<td>${semester.get(0).NUM}</td>
			<td>${semester.get(0).RANK}</td>
			<td>${semester.get(0).DEPT}</td>
		</tr>
		
		<tr>
			<td>${semester.get(1).NO}</td>
			<td>${semester.get(1).NAME}</td>
			<td>${semester.get(1).NUM}</td>
			<td>${semester.get(1).RANK}</td>
			<td>${semester.get(1).DEPT}</td>
		</tr>
				<tr>
			<td>${semester.get(2).NO}</td>
			<td>${semester.get(2).NAME}</td>
			<td>${semester.get(2).NUM}</td>
			<td>${semester.get(2).RANK}</td>
			<td>${semester.get(2).DEPT}</td>
		</tr>
		 
</table>


<!-- 
	${semester}<br>
	${semester.get(0)}<br>
	${semester.get(0).NAME}<br>
	${semester.get(0).NUM}<br>
	${semester.get(0).RANK}<br>	
	${semester.get(0).DEPT}<br>	
	${semester.size()}<br>
	 -->
</body>
</html>