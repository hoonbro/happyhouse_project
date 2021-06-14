# 🏡 Happy House
부동산 웹 사이트

<br>

## 개발 기간 📆
* 2021년 5월 20일 ~ 5월 27일

<br>

## Tech Stack
### Frontend
    Vue.js
### Backend
    Spring boot, RestAPI
### Database
    MySQL

<br>

## 화면 설계
#### 1. 메인 화면
    - 로그인, 회원가입 기능
    - 회원 정보 조회 기능
    - Select box를 이용해 매물 검색 기능
    - 뉴스, 게시판 미리보기 기능
![메인](https://user-images.githubusercontent.com/62068895/121524307-24d44a00-ca32-11eb-90e7-9c8cc49e249d.PNG)

<br>

#### 2. 회원정보 조회/수정/탈퇴 & 상세 주소 검색
    - 사용자 정보 조회
    - 사용자 정보 수정 및 회원 탈퇴 가능
    - 카카오 우편주소 API를 사용하여 주소 세팅
![회원정보 조회 상세 주소 검색](https://user-images.githubusercontent.com/62068895/121524537-5fd67d80-ca32-11eb-8412-9a7c891e0d1b.PNG)

<br>

#### 3. 연도별 차트 조회
    - 2018 ~ 2021 차트 조회
    - 아파트 매매/전세 가격지수 차트
    - 아파트 매매 수급동향 차트
    - 아파트 전세 수급동향 차트
![2020년 차트](https://user-images.githubusercontent.com/62068895/121524616-6f55c680-ca32-11eb-839e-0f8c9512acaa.PNG)

<br>

#### 4. 게시판
    - 게시판 CRUD 기능
    - 키워드별 검색, 페이징 처리
    - 게시판 글 상세 조회
    - 조회수 계산
    - 로그인한 계정이 글 작성자면 글 수정, 삭제 가능
![게시판 CRUD](https://user-images.githubusercontent.com/62068895/121524751-97452a00-ca32-11eb-9915-e7059d2a9fc9.PNG)
![게시판 글 상세](https://user-images.githubusercontent.com/62068895/121524827-a926cd00-ca32-11eb-8091-a468320f44b9.PNG)

<br>

#### 5. 오늘의 뉴스
    - 네이버 검색 API 사용 실시간 뉴스 검색 기능
    - 키워드 검색, 페이징 처리
    - 뉴스 상세 조회
    - 네이버 뉴스 본문 링크 제공
    - 언론사 본문 링크 제공
![부동산 뉴스 검색 날짜 기준 정렬](https://user-images.githubusercontent.com/62068895/121524911-bfcd2400-ca32-11eb-8dba-18aa7942616c.PNG)
![뉴스 상세 페이지 뉴스 본문 링크 제공](https://user-images.githubusercontent.com/62068895/121524870-b5ab2580-ca32-11eb-8309-1c26ee652cb1.PNG)

<br>

#### 6. 아파트 매물 검색 & 날씨 조회
    - 동 별 검색 시 지도에 아파트 목록을 마커로 조회 가능
    - 화면 우측 상단 부터 ‘지역 정보’ , ‘날씨’ , ‘매물 목록’ 조회 가능
    - 매물 목록에 대한 페이징 처리
![아파트 매물 검색 날씨 조회](https://user-images.githubusercontent.com/62068895/121529567-7df2ac80-ca37-11eb-83e4-dbb9fbe1ac5b.PNG)

<br>

#### 7. 아파트 매물 상세 & 주변 편의시설 조회
    - 매물 목록 아이템 클릭시 , 해당 매물 아파트 상세 목록 조회 가능(가격, 평수, 층 수, 페이징 처리)
    - 해당 매물의 거래가격을 사용자 편의를 생각해 데이터 가공하여 출력
    - 지도 왼쪽 상단 주변 편의시설 마커로 조회 가능
![매물 상세 정보 주변 편의시설 조회](https://user-images.githubusercontent.com/62068895/121529612-8b0f9b80-ca37-11eb-9b1b-be2d80d9da70.PNG)
