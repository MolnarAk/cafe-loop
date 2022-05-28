<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main.css">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">

    <meta charset="UTF-8">
    <title>Kezdőlap</title>
</head>
<body>

<%@include file="fragments/navbar.jsp" %>

<div class="container-fluid bg-1 text-center">
    <h1 class="margin">Kik vagyunk?</h1>
    <img src="images/logo-big.png" class="img-responsive img-circle margin" style="display:inline;" alt="Bird"
         width="250" height="250">
    <h2>Kávé fanatikusok!</h2>
</div>

<div class="container-fluid bg-2 text-center">
    <h3 class="margin">Hiszünk a frissen pörkölt kávé erejében!</h3>
    <p>
        Egy igazán jó kávé az élet egyik legnagyobb öröme: az íze, az illata és a meleg csésze érzete a kezeidben
        egyszerűen fenomenális. De ha a kávéd a boltból érkezik, akkor a kirakós egy nagy darabját elmulasztod: <b>az
        igazán friss kávét!</b> A kávé frissen pörkölve a legjobb, szóval ha azokat a kávébabokat veszed, amik heteket a
        polcokon töltenek, akkor minden bizonnyal kimarad az igazi kávé élmény az életedből.
    </p>
</div>

<div class="container-fluid bg-3 text-center">
    <h1 class="margin">De miért is igyál kávét?</h1><br>
    <div class="row">
        <div class="col-sm-4">
            <h3>Segít tovább élni!</h3>
            <p>A kávé legfontosabb jótékony hatása, hogy a kávét fogyasztók hosszabb ideig élnek, mint azok, akik nem
                isszák. Egy 2016-os tanulmány szerint azok az emberek, akik napi 4 csésze kávét isznak, (mint azt
                feljebb megtudhattuk, hogy annyi a maximális napi fogyasztása) bármilyen betegség okozta halál ritkábban
                fordult elő, mint a nem kávézók között, és ebbe beletartozik a szívbetegségek és a rák által okozott
                halál is.</p>
        </div>
        <div class="col-sm-4">
            <h3>Serkenti az agyműködést!</h3>
            <p>A kávé jó hatással van az agyműködésre is. Sokan pont e miatt a hatás miatt kortyolnak el napközben
                egy-két csésze feketekávét. A koffein blokkolja az álmosságérzetért felelős hormont, az adenozint, ezzel
                ébren tartva az agyat. Érdekes belegondolni, hogy a kávé a leggyakrabban használt tudatmódosítószer a
                világon.</p>
        </div>
        <div class="col-sm-4">
            <h3>Növeli a teljesítményt!</h3>
            <p>Ez szorosan hozzátartozik a koffein serkentő hatásához. A koffein, már említett adenozin gátló hatásának
                köszönhetően extra energiával tölti el a szervezetet, melynek hatására megnő a teljesítmény, és a
                koncentráció is fokozódik. Az edzés előtt elfogyasztott kávé így nem csak a zsírégetésben játszik
                kulcsfontosságú szerepet, hanem abban is, hogy nagyobb intenzitással és hatékonyabban menjen az
                testmozgás.</p>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-4">
            <img src="images/welcome-1.jpeg" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-4">
            <img src="images/welcome-2.jpeg" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-4">
            <img src="images/welcome-3.jpeg" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
    </div>
</div>

<div class="container-fluid bg-2 text-center">
    <h1 class="margin">Miért rendeld tőlünk a kávét?</h1>
    <p>
        Minden nap frissen pörköljük a legfinomabb kávébabokat és szállítjuk ki ügyfeleinknek, így azonnal friss és jó
        minőségű kávéhoz juthatnak.
    </p>
    <div class="row">
        <div class="col-sm-6">
            <h2>Hogy működik?</h2>
            <p>Hozz létre egy fiókot regisztációval, majd készíts feliratkozást a szállítási adatok megadásával
                (egyszerre akár több feliratkozási tervet is megadhatsz). A többiről mi gondoskodunk.</p>
        </div>
        <div class="col-sm-6">
            <h2>Mit tartalmaz egy feliratkozás?</h2>
            <p>Kiválaszthatod a számodra legmegfelelőbb kávébabot a nagy választékunkból és a szállítás gyakoriságát
                is. A feliratkozás bármikor módosítható és lemondható.</p>
        </div>
    </div>
</div>

<div class="container-fluid bg-3 text-center">
    <p>A szolgáltatásunk igénybe vételéhez csak regisztrálnod kell. A regisztráció után feliratkozhatsz
        szolgáltatásunkra szállítási terv létrehozásával.</p>
    <a href="#" class="btn btn-default btn-lg">
        Regisztráció
    </a>
</div>


</body>
</html