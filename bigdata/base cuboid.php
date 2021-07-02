<?php 
	error_reporting(E_ALL^E_NOTICE^E_WARNING);//把錯誤關閉
	$link = mysqli_connect( 
					'localhost',  // MySQL主機名稱 
					'root',       // 使用者名稱 
					'',  // 密碼
					'bigdata');  // 預設使用的資料庫名稱
	
	mysqli_query($link,"SET CHARACTER SET UTF8");
	$sql="SELECT 
				sex.sex_name,
				age.age_category,
				location.region,
				location.city,
				location.district,
				income.income_category,
				date.year,
				date.month,
				date.day,
				consum_cat.consum_type,
				pay.pay_type,
				pay.payby_type,
				SUM(fact.quantity),
    			SUM(fact.amount),
    			SUM(fact.ad)
	      FROM 
	      		fact 
				LEFT JOIN sex ON sex.sex_id = fact.sex_id
				LEFT JOIN income ON income.income_id = fact.income_id
				LEFT JOIN location ON location.location_id = fact.location_id
				LEFT JOIN date ON date.date_id = fact.date_id
				LEFT JOIN consum_cat ON consum_cat.consum_id = fact.cosume_id
				LEFT JOIN pay ON pay.pay_id = fact.pay_id
				LEFT JOIN age ON age.age_id = fact.age_id
	      
			
		  GROUP BY
			date.day,
			sex.sex_name,
			income.income_category,
			pay.payby_type,
			location.district,
			age.age_category"
			
			;
				
//WITH ROLLUP 
	$result=mysqli_query($link,$sql)
?>
<html>
<center>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf8">
	<title>connection</title>
</head>
<body>
    <table  border='1'>
	<tr>
		<td><center>性別</td>
		<td><center>年齡</td>
		<td><center>居住地</td>
		<td><center>年收入</td>
		<td><center>時間</td>
		<td><center>消費種類</td>
		<td><center>付款別</td>
		<td><center>訂購量</td>
		<td><center>金額</td>
		<td><center>廣告觀看時間</td>
  </tr>
	<?php
	
    for($i=1;$i<=mysqli_num_rows($result);$i++)
       {
        $rs=mysqli_fetch_row($result);
		$value = str_pad($rs[7],2,'0',STR_PAD_LEFT);
		$value2 = str_pad($rs[8],2,'0',STR_PAD_LEFT);
        echo '<tr>';
        echo '<td><center>'.$rs[0].'</td>';
        echo '<td><center>'.$rs[1].'</td>';
        echo '<td><center>'.$rs[2].''.$rs[3] .''.$rs[4] .'</td>';
        echo '<td><center>'.$rs[5].'</td>'; //年收入
		echo '<td><center>'.$rs[6].''.$value.''.$value2.'</td>';//時間
		echo '<td><center>'.$rs[9].'</td>';//消費種類
		echo '<td><center>'.$rs[10].''.$rs[11].'</td>';//付款別
        echo '<td><center>'.$rs[12].'</td>';
        echo '<td><center>'.$rs[13].'</td>';
		echo '<td><center>'.$rs[14].'</td>';
    	  echo '</tr>';
  	   }
    ?>
	</table>
	</body>
</html>

