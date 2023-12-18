function updateUI(sectionId) {
    const sections = document.getElementsByClassName('content');
    const navItems = document.getElementsByClassName('nav-item');

    for (let item of navItems) {
        item.classList.remove('active');
    }

    for (let section of sections) {
        section.style.display = 'none';
    }

    document.getElementById(sectionId).style.display = 'block';
    document.getElementById(sectionId + "-btn").classList.add('active');
    document.querySelector('.page-title').textContent = sectionId.charAt(0).toUpperCase() + sectionId.slice(1);
}

async function fetchEmployeeData(sectionId) {
        const options = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json;' },
        };

        try {
            const result = await fetch('employee', options);
            console.log(result);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
}

async function fetchGuestData(sectionId) {
        const options = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json;' },
        };

        try {
            const result = await fetch('guest', options);
            console.log(result);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
}


async function fetchRoomData(sectionId) {
        const options = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json;' },
        };

        try {
            const result = await fetch('room', options);
            console.log(result);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
}



function showSection(sectionId) {
    fetchEmployeeData(sectionId);
    updateUI(sectionId);
    fetchGuestData(sectionId);
    fetchRoomData(sectionId);
}
