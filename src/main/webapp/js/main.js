function sendSectionForm(section) {
    let form = document.getElementById('sectionForm');
    form[0].value = section;
    form.submit();
}

let $input = function(type, name, value) {
    let input = document.createElement('input');
    input.type = type;
    input.name = name;
    input.value = value || '';
    return input;
}

function sendActionForm(action, idConf) {
    let form = document.getElementById('actionForm');

    form.append($input('hidden','action', action));
    form.append($input('hidden','section', 'home'));
    idConf && form.append($input('hidden','idConf', idConf));

    form.submit();
}

function addEvent() {
    let form = document.getElementById('newConfForm');
    let event = document.createElement('div');

    event.classList.add('event');
    event.innerHTML = '<h2 class="login__title">Event:</h2>';
    event.append($input('text', 'titleEvent'));
    event.append($input('time', 'time'));
    form.append(event);
}

function removeEvent() {
    let form = document.getElementById('newConfForm');
    let event = document.querySelector('.event');
    form.removeChild(event);
}