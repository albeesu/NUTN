<style type="text/css">
.ccle {
  margin: 0px auto;/*div對齊效果*/
  text-align: center;/*display: inline對齊效果*/
}
.ccle div {
  display: inline-block;/*讓div並排*/ 
  vertical-align: top;/*就算個個div行數不同，也一律向上對齊*/ 
  width: 500px;
  height: 200%;
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
)UNION
(SELECT 
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
				consum_cat.consum_type='服飾用品'
		  GROUP BY
				consum_cat.consum_type,
				date.month
)UNION
(SELECT 
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
				consum_cat.consum_type='美妝保健 '
		  GROUP BY
				consum_cat.consum_type,
				date.month
)UNION
(SELECT 
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
				consum_cat.consum_type='其他'
		  GROUP BY
				consum_cat.consum_type,
				date.month
)UNION
(SELECT 
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
				consum_cat.consum_type='電器用品'
		  GROUP BY
				consum_cat.consum_type,
				date.month
)UNION
(SELECT 
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
				consum_cat.consum_type='生活百貨'
		  GROUP BY
				consum_cat.consum_type,
				date.month
)UNION
(SELECT 
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
				consum_cat.consum_type='食品飲料'
		  GROUP BY
				consum_cat.consum_type,
				date.month
)
			"
			
			;
				

	$result=mysqli_query($link,$sql)
?>
<hr>
<h2>總月報表</h2>
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
	

	$money[1]=array(0,0,0,0,0,0,0,0,0,0,0,0);
	$money[2]=array(0,0,0,0,0,0,0,0,0,0,0,0);
	$money[3]=array(0,0,0,0,0,0,0,0,0,0,0,0);
	$money[4]=array(0,0,0,0,0,0,0,0,0,0,0,0);
	$money[5]=array(0,0,0,0,0,0,0,0,0,0,0,0);
	$money[6]=array(0,0,0,0,0,0,0,0,0,0,0,0);
	$money[7]=array(0,0,0,0,0,0,0,0,0,0,0,0);
	$temp="123";
	$num=0;
	$flag=0;
    for($i=1;$i<=mysqli_num_rows($result);$i++)
       {
        $rs=mysqli_fetch_row($result);
		if($temp!=$rs[0]){
			$temp=$rs[0];
			$num=$num+1;//不重複
			
		}
		echo '<tr>';
        echo '<td><center>'.$rs[0].'</td>';
		echo '<td><center>'.$rs[2].'</td>';
		echo '<td><center>'.$rs[1].'</td>';
		$money[$num][$rs[2]]=$rs[1];
		
	   }
    ?>
</table>


</div>
<div>
<canvas id="myChart3" style="height:600px; width:1000px"></canvas>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

<script>
var ctx = document.getElementById('myChart3').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'line',

    // The data for our dataset
    data: {
        labels: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
        datasets: [{
            label: '教育娛樂',
            //backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb( 176,48, 96)',
            data:[ <?PHP print_r($money[1][1]);echo ",";print_r($money[1][2]);echo ",";print_r($money[1][3]);echo ",";print_r($money[1][4]);echo ",";print_r($money[1][5]);echo ",";print_r($money[1][6]);echo ",";print_r($money[1][7]);echo ",";print_r($money[1][8]);echo ",";print_r($money[1][9]);echo ",";print_r($money[1][10]);echo ",";print_r($money[1][11]);echo ",";print_r($money[1][12]); ?>]
        },
		{
            label: '服飾用品',
            //backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb( 255,69, 0)',
            data:[ <?PHP print_r($money[2][1]);echo ",";print_r($money[2][2]);echo ",";print_r($money[2][3]);echo ",";print_r($money[2][4]);echo ",";print_r($money[2][5]);echo ",";print_r($money[2][6]);echo ",";print_r($money[2][7]);echo ",";print_r($money[2][8]);echo ",";print_r($money[2][9]);echo ",";print_r($money[2][10]);echo ",";print_r($money[2][11]);echo ",";print_r($money[2][12]); ?>]
        },
		{
            label: '美妝保健',
            //backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb( 255,235, 205)',
            data:[ <?PHP print_r($money[3][1]);echo ",";print_r($money[3][2]);echo ",";print_r($money[3][3]);echo ",";print_r($money[3][4]);echo ",";print_r($money[3][5]);echo ",";print_r($money[3][6]);echo ",";print_r($money[3][7]);echo ",";print_r($money[3][8]);echo ",";print_r($money[3][9]);echo ",";print_r($money[3][10]);echo ",";print_r($money[3][11]);echo ",";print_r($money[3][12]); ?>]
        },
		{
            label: '其他',
            //backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb( 0,201, 87)',
            data:[ <?PHP print_r($money[4][1]);echo ",";print_r($money[4][2]);echo ",";print_r($money[4][3]);echo ",";print_r($money[4][4]);echo ",";print_r($money[4][5]);echo ",";print_r($money[4][6]);echo ",";print_r($money[4][7]);echo ",";print_r($money[4][8]);echo ",";print_r($money[4][9]);echo ",";print_r($money[4][10]);echo ",";print_r($money[4][11]);echo ",";print_r($money[4][12]); ?>]
        },
		{
            label: '電器用品',
            //backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb( 99,132, 255)',
            data:[ <?PHP print_r($money[5][1]);echo ",";print_r($money[5][2]);echo ",";print_r($money[5][3]);echo ",";print_r($money[5][4]);echo ",";print_r($money[5][5]);echo ",";print_r($money[5][6]);echo ",";print_r($money[5][7]);echo ",";print_r($money[5][8]);echo ",";print_r($money[5][9]);echo ",";print_r($money[5][10]);echo ",";print_r($money[5][11]);echo ",";print_r($money[5][12]); ?>]
        },
		{
            label: '生活百貨',
            //backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb( 160,32, 640)',
            data:[ <?PHP print_r($money[6][1]);echo ",";print_r($money[6][2]);echo ",";print_r($money[6][3]);echo ",";print_r($money[6][4]);echo ",";print_r($money[6][5]);echo ",";print_r($money[6][6]);echo ",";print_r($money[6][7]);echo ",";print_r($money[6][8]);echo ",";print_r($money[6][9]);echo ",";print_r($money[6][10]);echo ",";print_r($money[6][11]);echo ",";print_r($money[6][12]); ?>]
        },
		{
            label: '食品飲料',
            //backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb( 3,168, 156)',
            data:[ <?PHP print_r($money[7][1]);echo ",";print_r($money[7][2]);echo ",";print_r($money[7][3]);echo ",";print_r($money[7][4]);echo ",";print_r($money[7][5]);echo ",";print_r($money[7][6]);echo ",";print_r($money[7][7]);echo ",";print_r($money[7][8]);echo ",";print_r($money[7][9]);echo ",";print_r($money[7][10]);echo ",";print_r($money[7][11]);echo ",";print_r($money[7][12]); ?>]
        }]
    },

    // Configuration options go here
    options: {}
});



</script>
</div>























