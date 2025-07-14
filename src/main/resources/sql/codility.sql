-- 找出在 2024 年下单超过 5 次的客户。
select
	customer_id,
	count(order_id) as count_order
from orders
where date between '2024-01-01' and '2024-12-31'
group by customer_id
having count_order > 5;

select
	customer_id
from (
	select
		customer_id,
		count(order_id) as count
	from orders
	where date between '2024-01-01' and '2024-12-31'
	group by customer_id
	) as t1
where count > 5;

-- 找出用户在同一周内下了超过 3 个订单的用户 ID 和下单次数。
select
	t1.user_id, t1.order_count, t1.order_week
from
	(
	select
		user_id,
		to_char(order_date, 'IYYY-IW') as order_week,
		count(*) as order_count
	from orders
	group by user_id, to_char(order_date, 'IYYY-IW')
	) as t1
where order_count > 3;

--编写 SQL 查询，找出销售额前 3 的产品（使用 sales 表，其中包含 product_id 和 amount 字段）。
select
	product_id,
	sum(amount) as total_amount
from sales
group by product_id
order by total_amount desc;
limit 0,3;

--查询 orders 表中每个月的总销售额，按月份升序排列
select
	to_char(date, 'YYYY-mm') as month,
	sum(amount) as total_amount
from orders
group by to_char(date, 'YYYY-mm')
order by month asc;

--找出至少购买过两种不同商品的用户 ID
select
	user_id
from orders
group by user_id
having count(distinct product_id) >= 2

select
	t1.user_id
from (
	select
		user_id,
		count(distinct product_id) as product_count
	from orders
	group by user_id
	) as t1
where t1.product_count >= 2

--找出过去 30 天内下单最多的前 5 个客户。
select
	user_id,
	count(*) as order_count
from orders
where order_date >= CURRENT_DATE - INTERVAL '30 days'
group by user_id
order by order_count desc
limit 0,5;

-- 查询过去 30 天中，每天订单量最多的前 5 天。
select
	to_char(order_date, 'YYYY-MM-DD') as order_day_format,
	count(*) as order_count
from orders
where order_date >= CURRENT_DATE - interval '30 days'
group by to_char(order_date, 'YYYY-MM-DD')
order by order_count desc
limit 5 offset 0;


-- 查找 2024 年 1 月份每天的订单数量。
select
	DATE(order_date) as order_date_format,
	count(*) as order_count
from sales
where order_date between '2024-01-01 00:00:00' and '2024-01-31 23:59:59'
group by order_date_format
order by order_date_format;

select
	to_char(order_date, 'YYYY-MM-DD') as order_day_format,
	count(*) as order_count
from sales
where order_date between '2024-01-01 00:00:00' and '2024-01-31 23:59:59'
group by order_day_format
order by order_day_format;

--查询每个客户最后一次下单的时间和金额
select
	t1.user_id,
	t1.order_date,
	t1.amount
from orders t1,
	(
	select
		user_id, max(order_date) as last_order_date
	from orders
	group by user_id
	) as t2
where t1.user_id = t2.user_id
and t1.order_date = t2.last_order_date

--统计 transactions 表中每种交易类型的总金额和交易次数
select
	type,
	sum(amount) as total_amount,
	count(*) as total_count
from transactions
group by type;

-- 查询 employees 表中，薪资高于公司平均薪资的员工姓名和薪资。
select
	name, salary
from employees
where salary >
    (
	select
		avg(salary)
	from employees
	)


-- 消费总额高于平均水平的客户
select
	customer_id,
	sum(amount) as total_amount
from t_order
group by customer_id
having total_amount > (
	select
	    avg(t1.total)
	from
		(
		select
		    customer_id,
		    sum(amount) as total
		from t_order
		group by customer_id
		) as t1
	)


--找出销售额最高的 3 个产品名称和总销售额。
select
	product_name,
	sum(amount) as total_amount
from sales
group by product_name
order by total_amount desc
limit 0,3;

--查询每个部门的员工人数，按人数降序排列。
select
	department_id,
	count(*) as employee_count
from employees
group by department_id
order by employee_count desc;



--从 orders 表中查询客户 ID 和他们的首次下单日期
select
	customer_id,
	min(order_date) as first_order_date
from orders
group by customer_id



-- 从 employees 表中查找连续三个月薪资增长的员工 ID。
select
	distinct(employee_id)
from employees t1
JOIN employees t2
	on t1.employee_id = t2.employee_id
	and to_char(t2.salary_date, 'YYYY-MM') = to_char(t1.salary_date + interval '1 month', 'YYYY-MM')
JOIN employees t3
	on t1.employee_id = t3.employee_id
	and to_char(t3.salary_date, 'YYYY-MM') = to_char(t1.salary_date + interval '2 month', 'YYYY-MM')
where
	1 = 1
	and t1.salary < t2.salary
	and t2.salary < t3.salary;



-- 查询 products 表中，每类商品（category）平均价格最高的前两类。
select
	category,
	avg(price) as avg_price
from products
group by catagory
order by avg_price desc
limit 0,2;

-- 查询 orders 表中，每位用户最后一次下单的商品名称和时间。
select
	t1.product_name,
	t1.order_date
from orders t1
JOIN
	(
	select
		user_id,
		max(order_date) as last_order_date
	from orders
	group by user_id
	) as t2
on t1.user_id = t2.user_id
and t1.order_date = t2.last_order_date


-- 从 attendance 表中找出连续三天缺勤的员工 ID。
select
	distinct t1.employee_id
from attendance t1
JOIN attendance t2
	on t1.employee_id = t2.employee_id
	and t2.attendance_date = t1.attendance_date + interval '1 day'
	and t2.status = 'absent'
JOIN attendance t3
	on t1.employee_id = t3.employee_id
	and t3.attendance_date = t1.attendance_date + interval '2 day'
	and t3.status = 'absent'
where t1.status = 'absent';

-- 找出 2024 年每个月订单量最多的客户（customer_id）。
--order_count per customer per month
select
	customer_id,
	to_char(order_date, 'YYYY-MM') as month,
	count(*) as order_count
from orders
where order_date between '2024-01-01 00:00:00' and '2024-12-31 23:59:59'
group by customer_id, month

--max order_count per month
select
	t1.month,
	max(t1.order_count) as max_order_count
from
	(
	select
		customer_id,
		to_char(order_date, 'YYYY-MM') as month,
		count(*) as order_count
	from orders
	where order_date between '2024-01-01 00:00:00' and '2024-12-31 23:59:59'
	group by customer_id, month
	) t1
group by month

--customer_id of max order_count per month
select
	t2.customer_id,
	t2.month,
	t2.order_count
from
	(
	select
		customer_id,
		to_char(order_date, 'YYYY-MM') as month,
		count(*) as order_count
	from orders
	where order_date between '2024-01-01 00:00:00' and '2024-12-31 23:59:59'
	group by customer_id, month
	) t2
JOIN
	(
	select
		t1.month as month,
		max(t1.order_count) as max_order_count
	from
		(
		select
			customer_id,
			to_char(order_date, 'YYYY-MM') as month,
			count(*) as order_count
		from orders
		where order_date between '2024-01-01 00:00:00' and '2024-12-31 23:59:59'
		group by customer_id, month
		) t1
	group by month
	) t3
on t2.month = t3.month
and t2.order_count = t3.max_order_count
order by t2.month

-- 查询员工表中每位经理（manager_id）下属的平均工资。
select
	t1.employee_name,
	t2.avg_salary
from employee t1
JOIN (
	select
		manager_id,
		avg(salary) as avg_salary
	from employee
	where manager_id is not null
	group by manager_id
	) t2
on t1.employee_id = t2.manager_id
order by t1.employee_id

-- 从 sales 表中找出销售额超过平均值 2 倍的销售员和对应金额。
select
	employee_id, amount
from sales
where amount > (
	select
		avg(amount) * 2
	from sales
)

-- 从 orders 表中找出所有没有下过订单的客户 ID。
select
	t1.customer_id
from customer t1
left join orders t2
on t1.customer_id = t2.customer_id
and t2.order_id is null


-- 找出每个部门工资最高的员工信息（假设字段为 employee_id, department_id, salary）。
select
	t1.employee_id,
	t1.department_id,
	t1.salary
from department t1
JOIN (
	select
		department_id,
		max(salary) as max_salary
	from department
	group by department_id
	) as t2
on t1.department_id = t2.department_id
and t1.salary = t2.max_salary

-- 统计订单表中每种支付方式（payment_method）的订单数和总金额。
select
	payment_method,
	count(*) as order_count,
	sum(amount) as total_amount
from orders
group by payment_method;


-- 找出客户下的第一笔订单信息（包括订单号和日期）。
select
	t1.order_id,
	t2.min_order_date
from orders t1
JOIN (
	select
		customer_id,
		min(order_date) as min_order_date
	from orders
	group by customer_id
	) as t2
on t1.customer_id = t2.customer_id
and t1.order_date = t2.min_order_date



