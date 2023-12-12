function showSection(sectionId) {
    var sections = document.getElementsByClassName('content');
    var navItems = document.getElementsByClassName('nav-item');
    
    for (var i = 0; i < sections.length; i++) {
        sections[i].style.display = 'none';
        navItems[i].classList.remove('active');
    }
    
    document.getElementById(sectionId).style.display = 'block';
    document.getElementById(sectionId + 'Btn').classList.add('active');
    
    document.querySelector('.page-title').textContent = sectionId.charAt(0).toUpperCase() + sectionId.slice(1);
}

document.getElementById('dashboardBtn').classList.add('active');

