//
// This is only a SKELETON file for the 'Bob' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const hey = (message) => {
  // Handle empty or null messages
  if (message === null || message.trim() === "") {
    return 'Fine. Be that way!';
  }

  // Check if the message is in all uppercase (shouting) and contains at least one letter
  if (message === message.toUpperCase() && /[A-Za-z]/.test(message)) {
    // If the message ends with a question mark, it's considered shouting in a question
    if (message.endsWith('?')) {
      return 'Calm down, I know what I\'m doing!';
    }
    return 'Whoa, chill out!';
  }

  // If the message is a question (ends with a question mark)
  if (message.trim().endsWith('?')) {
    return 'Sure.';
  }

  // For any other case, return "Whatever."
  return 'Whatever.';
};

  