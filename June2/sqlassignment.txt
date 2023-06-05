select * from emp; --1
select distinct job from emp;--2
select * from emp where job='MANAGER';--3

SELECT ename
FROM emp
WHERE hiredate < DATE '1981-01-01';--4

select empno,ename,job,hiredate, TRUNC(MONTHS_BETWEEN(SYSDATE, hiredate) / 12) AS years_of_experience from emp; --5

select empno,ename, sal, trunc(Months_between(sysdate,hiredate)/12) as experience from emp where mgr=7839;--6

select * from emp where comm> sal;--7

select empno,ename, trunc(months_between(sysdate,hiredate)/12) as experience, sal/30 as daily_sal from  emp  where (sal/30)>100;--8 

select ename from emp where  deptno=10 or deptno=20;--9
select ename from emp where MGR is not null;--10
select ename from emp where job='CLERK';--11
select * from emp where ename='SMITH';--12

select empno,ename,deptno from emp ;--13
select empno,deptno from emp;--14
select distinct deptno from emp;--15
select ename from emp where (sal*1.2)>3000;--16
select ename ,sal*1.15 as salary$ from emp;--17
select ename,job, ename || job as emp_and_job from emp;--18
select empno,ename,sal from emp where job='MANAGER';--19

select ename, sal*12 annual_salary from emp where sal*12>30000; --20
select distinct empno from emp; --21

select empno,sal,comm from emp;--22
select distinct deptno,job from emp;--23
select * from emp where ename='BLAKE';--24
select *  from emp where job='CLERK'; --25
select * from emp where hiredate='01-05-81';--26
select ename from emp where sal<3500;--27
select empno,ename , sal from emp where hiredate< DATE '1981-04-01'; --28
select ename,trunc(months_between(sysdate,hiredate)/12) experience from emp where trunc(months_between(sysdate,hiredate)/12)>10;--29
select ename,job from emp where job='MANAGER';--30
select ename, job ,trunc(months_between(sysdate,hiredate)/12) as experience from emp where job='CLERK' and trunc(months_between(sysdate,hiredate)/12)>8;--31
select empno,ename, job,sal from emp where sal*12<34000 and comm is not null and comm<sal; --32
select ename , job from emp where job='SALESMAN' and comm is not null;--33
select ename ,job from emp where job='SALESMAN' and deptno=30 and comm> sal; --34
select * from emp where ROWNUM<=5;--36
select empno,ename,job,sal from emp;--37
select distinct deptno from emp; --38
select distinct deptno,job from emp;--39
select * from emp where  ename='MILLER';--40
select * from emp where deptno=10;--41
select * from emp where job='SALESMAN'; --42
select ename,hiredate from emp where hiredate<DATE '1984-01-01'; --43
select ename,sal from emp where sal>2500; --44
select ename , hiredate from emp where hiredate >DATE '1982-04-01';--45
select empno,ename,sal , trunc(sal/30) as daily_sal from emp;--46
select empno,ename,sal, trunc(months_between(sysdate,hiredate)/12) as exp from emp where job='ANALYST'; --47
select ename, trunc(months_between(sysdate,hiredate)/12,1) as exp from emp where trunc(months_between(sysdate,hiredate)/12,1)>6.5; --48
select ename ,  hiredate from emp where hiredate> DATE '1981-06-30' and hiredate< DATE '1982-01-01'; --49
select ename , job, deptno from emp where job='CLERK' and deptno=10; --50
select ename, sal, hiredate from emp where sal>3000 and hiredate < DATE '1985-01-01'; --51
