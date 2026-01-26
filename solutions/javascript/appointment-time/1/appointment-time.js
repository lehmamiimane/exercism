// @ts-check


/**
 * Create an appointment
 *
 * @param {number} days
 * @param {number} [now] (ms since the epoch, or undefined)
 *
 * @returns {Date} the appointment
 */
export function createAppointment(days, now = undefined) {
  const d = new Date(now ?? Date.now());
  /*
    This fails because within the next 124 days, DST will occur and the time will change
    d.setDate(d.getDate() + days);
    return d;
  */
  const milliseconds = days * 24 * 60 * 60 * 1000;
  return new Date(d.getTime() + milliseconds);
}
/**
 * Generate the appointment timestamp
 *
 * @param {Date} appointmentDate
 *
 * @returns {string} timestamp
 */
export function getAppointmentTimestamp(appointmentDate) {
  return appointmentDate.toISOString();
}
/**
 * Get details of an appointment
 *
 * @param {string} timestamp (ISO 8601)
 *
 * @returns {Record<'year' | 'month' | 'date' | 'hour' | 'minute', number>} the appointment details
 */
export function getAppointmentDetails(timestamp) {
  const d = new Date(timestamp);
  return {
    year: d.getFullYear(),
    month: d.getMonth(),
    date: d.getDate(),
    hour: d.getHours(),
    minute: d.getMinutes(),
  };
}
/**
 * Update an appointment with given options
 *
 * @param {string} timestamp (ISO 8601)
 * @param {Partial<Record<'year' | 'month' | 'date' | 'hour' | 'minute', number>>} options
 *
 * @returns {Record<'year' | 'month' | 'date' | 'hour' | 'minute', number>} the appointment details
 */
export function updateAppointment(timestamp, options) {
  const d = new Date(timestamp);
  d.setFullYear(options.year ?? d.getFullYear());
  d.setMonth(options.month ?? d.getMonth());
  d.setDate(options.date ?? d.getDate());
  d.setHours(options.hour ?? d.getHours());
  d.setMinutes(options.minute ?? d.getMinutes());
  return getAppointmentDetails(d.toISOString());
}
/**
 * Get available time in seconds (rounded) between two appointments
 *
 * @param {string} timestampA (ISO 8601)
 * @param {string} timestampB (ISO 8601)
 *
 * @returns {number} amount of seconds (rounded)
 */
export function timeBetween(timestampA, timestampB) {
  return Math.round(
    Math.abs(
      (new Date(timestampA).getTime() - new Date(timestampB).getTime()) / 1000
    )
  );
}
/**
 * Get available times between two appointment
 *
 * @param {string} appointmentTimestamp (ISO 8601)
 * @param {string} currentTimestamp (ISO 8601)
 */
export function isValid(appointmentTimestamp, currentTimestamp) {
  return currentTimestamp < appointmentTimestamp;
}