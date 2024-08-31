<script>
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import timeGridPlugin from '@fullcalendar/timegrid';
import FullCalendar from '@fullcalendar/vue3';
import { defineComponent } from 'vue';
import { INITIAL_EVENTS, createEventId } from '/src/views/pages/calendar/utils/event-utils.js';

export default defineComponent({
    components: {
        FullCalendar
    },
    data() {
        return {
            calendarOptions: {
                plugins: [dayGridPlugin, timeGridPlugin, interactionPlugin],
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay'
                },
                initialView: 'dayGridMonth',
                initialEvents: INITIAL_EVENTS,
                editable: true,
                selectable: true,
                selectMirror: true,
                dayMaxEvents: true,
                weekends: true,
                select: this.handleDateSelect,
                eventClick: this.handleEventClick,
                eventsSet: this.handleEvents
            },
            currentEvents: []
        };
    },
    methods: {
        handleWeekendsToggle() {
            this.calendarOptions.weekends = !this.calendarOptions.weekends;
        },
        handleDateSelect(selectInfo) {
            let title = prompt('Please enter a new title for your event');
            let calendarApi = selectInfo.view.calendar;

            calendarApi.unselect();

            if (title) {
                calendarApi.addEvent({
                    id: createEventId(),
                    title,
                    start: selectInfo.startStr,
                    end: selectInfo.endStr,
                    allDay: selectInfo.allDay
                });
            }
        },
        handleEventClick(clickInfo) {
            if (confirm(`Are you sure you want to delete the event '${clickInfo.event.title}'`)) {
                clickInfo.event.remove();
            }
        },
        handleEvents(events) {
            this.currentEvents = events;
        }
    }
});
</script>

<template>
    <div class="demo-app">
        <div class="demo-app-sidebar">
            <div class="demo-app-sidebar-section">
                <h2>사용법</h2>
                <ul>
                    <li>날짜를 클릭해서 이벤트를 추가할 수 있습니다.</li>
                    <li>생성된 이벤트를 다른 날짜로 옮기거나, 당겨서 날짜를 늘릴 수 있습니다.</li>
                    <li>클릭해서 이벤트를 삭제할 수 있습니다.</li>
                </ul>
            </div>
            <div class="demo-app-sidebar-section">
                <label>
                    <input type="checkbox" :checked="calendarOptions.weekends" @change="handleWeekendsToggle" />
                    toggle weekends
                </label>
            </div>
            <div class="demo-app-sidebar-section">
                <h2>All Events ({{ currentEvents.length }})</h2>
                <ul>
                    <li v-for="event in currentEvents" :key="event.id">
                        <b>{{ event.startStr }}</b>
                        <i>{{ event.title }}</i>
                    </li>
                </ul>
            </div>
        </div>
        <div class="demo-app-main">
            <FullCalendar class="demo-app-calendar" :options="calendarOptions">
                <template v-slot:eventContent="arg">
                    <b>{{ arg.timeText }}</b>
                    <i>{{ arg.event.title }}</i>
                </template>
            </FullCalendar>
        </div>
    </div>
</template>

<style lang="css">
h2 {
    margin: 0;
    font-size: 16px;
}

ul {
    margin: 0;
    padding: 0 0 0 1.5em;
}

li {
    margin: 1.5em 0;
    padding: 0;
}

b {
    margin-right: 3px;
}

.demo-app {
    display: flex;
    min-height: 100%;
    font-family:
        Arial,
        Helvetica Neue,
        Helvetica,
        sans-serif;
    font-size: 14px;
}

.demo-app-sidebar {
    width: 300px;
    line-height: 1.5;
    background: #eaf9ff;
    border-right: 1px solid #d3e2e8;
}

.demo-app-sidebar-section {
    padding: 2em;
}

.demo-app-main {
    flex-grow: 1;
    padding: 3em;
}

.fc {
    max-width: 1100px;
    margin: 0 auto;
}
</style>
