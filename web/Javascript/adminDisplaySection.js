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
    if (sectionId === 'employees') {
        const options = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json;' },
        };

        try {
            const result = await fetch('employee', options);
            console.log(result);
            // Additional logic to handle the fetched data
        } catch (error) {
            console.error('Error fetching data:', error);
            // Error handling logic
        }
    }
}

async function deleteEmployee(employeeId) {
    console.log("trying to delete")
    const options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    };

    try {
        const result = await fetch(`/employee?employeeId=${employeeId}`, options);
        console.log(result);
    } catch (error) {
        console.error('Network error:', error);
    }
}


function showSection(sectionId) {
    updateUI(sectionId);
    fetchEmployeeData(sectionId);
}
