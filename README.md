![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/ee6e0c5e-3a4f-494a-ab07-46f56ac8b3d6)![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/662e7f91-d3b0-4a1b-b212-1620d5047441)# RGT-assignment

## 사용한 것
Spring, MySQL, JWT, OAuth, Docker

## 1. RESTful API 작성
### POST 요청 전송
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/c5da3647-d65b-4d90-aa70-7b0cdc68d8de)<br>
### INSERT 완료
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/01a021d1-5ab2-45b7-b8db-bca053f06e62)<br>

## 2. 중복데이터 처리 및 데이터 수정
### 2-1. 데이터 중복처리
#### `중복처리 이전`
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/e6579667-3b1f-414b-81f8-9589c3e5643a)
#### `중복처리 이후`
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/531cfff7-78c4-4e25-aec1-61cb9f5553e9)<br>
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/7eec3e18-87f4-4faf-bc7f-2603e74b53ad)

### 2-2. 데이터 수
#### `UPDATE 이전`
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/9e687843-7863-46ce-bb33-8f6159cf2fd7)
#### `UPDATE 이후`
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/643352c2-77d6-4612-9a20-d3e29ab96603)<br>
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/c0c03635-2df1-4cba-b39d-6d8d77b8f216)
#### `카페테리아는 INSERT 될 때 자동으로 체크되어 입력되는 즉시 카페라떼로 UPDATE`
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/91030189-6873-4524-9aa8-020f9e041514)

### 3. Google OAuth 2.0 로그인
#### 1. Login with google 사용 등록 완료
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/62b623b0-4321-441c-b5b1-4ed13257a428)<br>
#### 2. 구글로 로그인 클릭
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/ab561bc4-00e9-493e-958b-eb5bfe33e5d6)<br>
#### 4. 존재하지 않는 이메일이므로 회원가입 완료
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/5fb7adf8-1112-418f-818f-0e9c527b0f15)<br>
#### 5. 로그인 완료 후 JWT 발급 완료
![image](https://github.com/vacu9708/RGT-assignment/assets/67142421/cf59b268-be21-455d-a310-a1a31626352c)<br>



# 프로그램 실행 방법
1. docker, docker-compose 설치
2. build 폴더에서 build.bat 실행
3. docekr network create myNetwork
4. docker-compose-mysql 폴더에서 docker-compose up -d
5. schema.sql 실행
6. docker-compose-app 폴더에서 docekr-compose up -d
