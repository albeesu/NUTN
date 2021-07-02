<style type="text/css">
.ccle {
  margin: 0px auto;/*div對齊效果*/
  text-align: center;/*display: inline對齊效果*/
}
.ccle div {
  display: inline-block;/*讓div並排*/ 
  vertical-align: top;/*就算個個div行數不同，也一律向上對齊*/ 
  width: 500px;
  height: 60%;
  border-radius:3px;margin: 2px;
  }
</style>
<html>
<div class="ccle">
<?php 
	//error_reporting(E_ALL^E_NOTICE^E_WARNING);//把錯誤關閉
	$link = mysqli_connect( 
					'localhost',  // MySQL主機名稱 
					'root',       // 使用者名稱 
					'',  // 密碼
					'bigdata');  // 預設使用的資料庫名稱
	
	mysqli_query($link,"SET CHARACTER SET UTF8");
	$sql="(SELECT 
				consum_cat.consum_type,
				SUM(fact.amount),
				date.month
	      FROM 
	      		fact 
				LEFT JOIN sex ON sex.sex_id = fact.sex_id
				LEFT JOIN income ON income.income_id = fact.income_id
				LEFT JOIN location ON location.location_id = fact.location_id
				LEFT JOIN date ON date.date_id = fact.date_id
				LEFT JOIN consum_cat ON consum_cat.consum_id = fact.cosume_id
				LEFT JOIN pay ON pay.pay_id = fact.pay_id
				LEFT JOIN age ON age.age_id = fact.age_id
		  WHERE
				consum_cat.consum_type='教育娛樂'
		  GROUP BY
				consum_cat.consum_type,
				date.month
)
			"
			
			;
				

	$result=mysqli_query($link,$sql)
?>
<hr>
<h2>教育娛樂-月報表</h2>
<div>

<head>
	<meta http-equiv="content-type" content="text/html;charset=utf8">
	<title>bigdata</title>
</head>
<center>
<body>
    <table  border='1'>
	<tr>
		<td><center>消費種類</td>
		<td><center>月份</td>
		<td><center>消費金額</td>
  </tr>
	<?php
	
	$money=array(0,0,0,0,0,0,0,0,0,0,0,0);
    for($i=1;$i<=mysqli_num_rows($result);$i++)
       {
        $rs=mysqli_fetch_row($result);
        echo '<tr>';
        echo '<td><center>'.$rs[0].'</td>';
		echo '<td><center>'.$rs[2].'</td>';
		echo '<td><center>'.$rs[1].'</td>';
		$money[$rs[2]]=$rs[1];

  	   }
    ?>
</table>


</div>
<div>
<canvas id="myChart" style="height:600px; width:1000px"></canvas>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

<script>
var ctx = document.getElementById('myChart').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'line',

    // The data for our dataset
    data: {
        labels: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
        datasets: [{
            label: '消費金額',
            //backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb( 99,132, 255)',
            data:[ <?PHP echo "$money[1],$money[2],$money[3],$money[4],$money[5],$money[6],$money[7],$money[8],$money[9],$money[10],$money[11],$money[12]"; ?>]
        }]
    },

    // Configuration options go here
    options: {}
});
</script>
</div>
<?php 
	$link = mysqli_connect( 
					'localhost',  // MySQL主機名稱 
					'root',       // 使用者名稱 
					'',  // 密碼
					'bigdata');  // 預設使用的資料庫名稱
	
	mysqli_query($link,"SET CHARACTER SET UTF8");
	$sql="(SELECT 
				consum_cat.consum_type,
				SUM(fact.amount),
				date.season
	      FROM 
	      		fact 
				LEFT JOIN sex ON sex.sex_id = fact.sex_id
				LEFT JOIN income ON income.income_id = fact.income_id
				LEFT JOIN location ON location.location_id = fact.location_id
				LEFT JOIN date ON date.date_id = fact.date_id
				LEFT JOIN consum_cat ON consum_cat.consum_id = fact.cosume_id
				LEFT JOIN pay ON pay.pay_id = fact.pay_id
				LEFT JOIN age ON age.age_id = fact.age_id
		  WHERE
				consum_cat.consum_type='教育娛樂'
		  GROUP BY
				consum_cat.consum_type,
				date.season
)		";
				

	$result=mysqli_query($link,$sql)
?>
<hr>
<h2>教育娛樂-季報表</h2>
<div>

<head>
	<meta http-equiv="content-type" content="text/html;charset=utf8">
	<title>bigdata</title>
	

</head>
<center>
<body>
    <table  border='1'>
	<tr>
		<td><center>消費種類</td>
		<td><center>季</td>
		<td><center>消費金額</td>
  </tr>
	<?php
	
	$money=array(0,0,0,0,0,0,0,0,0,0,0,0);
    for($i=1;$i<=mysqli_num_rows($result);$i++)
       {
        $rs=mysqli_fetch_row($result);
        echo '<tr>';
        echo '<td><center>'.$rs[0].'</td>';
		echo '<td><center>'.$rs[2].'</td>';
		echo '<td><center>'.$rs[1].'</td>';
		$money[$rs[2]]=$rs[1];

  	   }
    ?>
</table>


</div>
<div>
<canvas id="myChart2" style="height:500px; width:1000px"></canvas>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<div>
<script>
var ctx = document.getElementById('myChart2').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'line',

    // The data for our dataset
    data: {
        labels: ['第1季', '第2季', '第3季', '第4季'],
        datasets: [{
            label: '消費金額',
            //backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb( 99,0, 255)',
            data:[ <?PHP echo "$money[1],$money[2],$money[3],$money[4]"; ?>]
        }]
    },

    // Configuration options go here
    options: {}
});
</script>
</div>




















